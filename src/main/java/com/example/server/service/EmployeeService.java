package com.example.server.service;

import com.example.server.entity.Employee;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class EmployeeService {


   private FirebaseService firebaseService;
   public String createEmployee(Employee employee) throws ExecutionException, InterruptedException {

       Firestore dbFirestore = FirestoreClient.getFirestore();
       ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("employee_admin").document(employee.getFirstName()).set(employee);
       return collectionsApiFuture.get().getUpdateTime().toString();
   }

   public Employee getEmployee(String documentId) throws ExecutionException, InterruptedException {
       Firestore dbFirestore = FirestoreClient.getFirestore();
       DocumentReference documentReference = dbFirestore.collection("employee_admin").document(documentId);
       ApiFuture<DocumentSnapshot> future = documentReference.get();
       DocumentSnapshot document = future.get();
       Employee employee;
       if(document.exists()){
           employee = document.toObject(Employee.class);
           return employee;
       }
       return null;
   }
    public String updateEmployee(Employee employee) throws ExecutionException, InterruptedException{

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("employee_admin").document(employee.getFirstName()).set(employee);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteEmployee(String documentId){
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("employee_admin").document(documentId).delete();
        return "You've successfully deleted employee " + documentId;
    }

    @Autowired
    public EmployeeService(FirebaseService firebaseService){
       this.firebaseService = firebaseService;
    }
    public List<Employee> getAllEmployee() {
       List<Employee> employees = firebaseService.getAllEmployees();
        return employees;
    }
}
