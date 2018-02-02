package iteso.com.sesion5;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {

    AutoCompleteTextView textView;
    Button cleanButton;
    EditText editName, editPhone;
    AutoCompleteTextView autoBook;
    Spinner spinnerSchool;
    CheckBox checkSports;
    RadioGroup radioGenero;
    RadioButton radioSelected, radioFem;
    Toast toast;
    int selection;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cleanButton = findViewById(R.id.activity_main_clean);
        editName = findViewById(R.id.activity_main_name);
        editPhone = findViewById(R.id.activity_main_phone);
        autoBook = findViewById(R.id.activity_main_books);
        spinnerSchool = findViewById(R.id.activity_main_spinner);
        checkSports = findViewById(R.id.activity_main_check);
        radioGenero = findViewById(R.id.activity_main_radio);
        radioFem = findViewById(R.id.radio_female);

        String[] libros = getResources().getStringArray(R.array.books);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, libros);
        autoBook.setAdapter(adapter);

        cleanButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ClearDataDialogFragment dialog = new ClearDataDialogFragment();
                dialog.show(getFragmentManager(), "clean");
            }
        });

        /*MÉTODO PARA ASIGNAR VALORES A UN SPINNER A TRAVÉS DE UN ADAPTER
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.degree,
                R.layout.spinner_layout);
        adapter1.setDropDownViewResource(R.layout.spinner_layout);
        spinnerSchool.setAdapter(adapter1);
        */
    }

    public void clean(){
        editName.getText().clear();
        editPhone.getText().clear();
        autoBook.getText().clear();
        checkSports.setChecked(false);
        spinnerSchool.setSelection(0);
        radioGenero.check(radioFem.getId());
    }

    public class ClearDataDialogFragment extends DialogFragment{
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState){
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("¿Seguro que quieres limpiar el contenido?");
            builder.setPositiveButton("Limpiar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    clean();
                }
            });
            builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //Meh
                }
            });
            return builder.create();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        selection = radioGenero.getCheckedRadioButtonId();
        radioSelected = findViewById(selection);
        switch (item.getItemId()) {
            case R.id.activity_main_save:
                Alumno alumno = new Alumno(
                        editName.getText().toString(), editPhone.getText().toString(),
                        spinnerSchool.getSelectedItem().toString(), radioSelected.getText().toString(),
                        autoBook.getText().toString(), checkSports.isChecked()
                );
                clean();
                toast = Toast.makeText(getApplicationContext(), alumno.toString(), Toast.LENGTH_LONG);
                toast.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
