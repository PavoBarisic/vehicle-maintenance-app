package ba.sum.fsre.carmaintenanceapp;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class VehicleRepository {
    private static VehicleRepository instance;
    private final FirebaseFirestore db;

    private VehicleRepository() {
        db = FirebaseFirestore.getInstance();
    }

    public static synchronized VehicleRepository getInstance() {
        if (instance == null) {
            instance = new VehicleRepository();
        }
        return instance;
    }

    public Task<Void> addVehicle(Vehicle vehicle) {
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        vehicle.setUserId(userId);
        return db.collection("vehicles")
                .document(vehicle.getLicensePlate())
                .set(vehicle);
    }
}