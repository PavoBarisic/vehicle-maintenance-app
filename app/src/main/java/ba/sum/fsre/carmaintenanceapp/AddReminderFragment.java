package ba.sum.fsre.carmaintenanceapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddReminderFragment extends Fragment {

    private FirebaseFirestore db;

    public AddReminderFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_reminder, container, false);

        db = FirebaseFirestore.getInstance();

        EditText reminderNameEditText = view.findViewById(R.id.reminderName);
        EditText reminderDateEditText = view.findViewById(R.id.reminderDate);
        MaterialButton saveButton = view.findViewById(R.id.save_button);
        MaterialButton cancelButton = view.findViewById(R.id.cancel_button);

        saveButton.setOnClickListener(v -> {
            String reminderName = reminderNameEditText.getText().toString().trim();
            String reminderDate = reminderDateEditText.getText().toString().trim();

            if (!reminderName.isEmpty() && !reminderDate.isEmpty()) {
                String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                Reminder reminder = new Reminder(reminderName, reminderDate);
                reminder.setUserID(userId);
                saveReminderToFirestore(reminder);
            } else {
                Toast.makeText(getActivity(), "Molimo popunite oba polja", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView backButton = view.findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> {
            if (getActivity() != null) {
                getActivity().onBackPressed();
            }
        });

        cancelButton.setOnClickListener(v -> {
            getActivity().getSupportFragmentManager().popBackStack();
        });

        return view;
    }

    private void saveReminderToFirestore(Reminder reminder) {
        db.collection("reminders")
                .add(reminder)
                .addOnSuccessListener(documentReference -> {
                    reminder.setId(documentReference.getId());
                    Toast.makeText(getActivity(), "Podsjetnik spremljen!", Toast.LENGTH_SHORT).show();
                    getActivity().getSupportFragmentManager().popBackStack();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(getActivity(), "Greška pri spremanju: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }
}