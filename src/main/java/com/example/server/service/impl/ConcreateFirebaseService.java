package com.example.server.service.impl;

import com.example.server.entity.Employee;
import com.example.server.service.FirebaseService;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ConcreateFirebaseService implements FirebaseService {
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        // Initialize Firebase Firestore
        Firestore firestore = FirestoreClient.getFirestore();

        // Specify the collection reference (replace "employees" with your actual collection name)
        CollectionReference employeesCollection = firestore.collection("employee_admin");

        // Fetch documents from the collection
        List<ApiFuture<DocumentSnapshot>> futures = new ArrayList<>();
        employeesCollection.listDocuments().forEach(documentReference -> {
            ApiFuture<DocumentSnapshot> future = documentReference.get();
            futures.add(future);
        });

        // Wait for all futures to complete
        List<DocumentSnapshot> documentSnapshots;
        try {
            documentSnapshots = ApiFutures.allAsList(futures).get();
        } catch (InterruptedException | ExecutionException e) {
            // Handle exceptions
            throw new RuntimeException("Error fetching documents from Firestore", e);
        }

        // Convert document snapshots to employees and add to the list
        for (DocumentSnapshot documentSnapshot : documentSnapshots) {
            if (documentSnapshot.exists()) {
                Employee employee = documentSnapshot.toObject(Employee.class);
                employees.add(employee);
            }
        }

        return employees;
    }
}
