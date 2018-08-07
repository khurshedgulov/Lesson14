package company.my.lesson14;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button openDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        openDialog = findViewById(R.id.opendialog);

        openDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Объявление и инициализация нового экземпляра диалога
                MyDialog dialog = new MyDialog();
                // Показать диалоговое окно
                dialog.show(getSupportFragmentManager(), "MyDialog");
            }
        });
    }
}
