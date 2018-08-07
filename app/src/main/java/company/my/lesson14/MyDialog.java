package company.my.lesson14;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MyDialog extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Объявить и инициализировать экземпляр класса AlertDialog.Builder с передачей контекста конструктору
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        // Установить заголовок диалогового окна
        alert.setMessage("Choose something");
        // Эта функция делает диалоговое окно не закрываемым по нажатию на кнопку назад или вне диаологового окна
        setCancelable(false);
        // Получить экземпляр класса LayoutInflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        // Присвоить полученный макет локальной переменной экземпляру класса View
        final View v = inflater.inflate(R.layout.dialog_layout, null, false);
        // Установить полученный макет в качестве макета диалогового окна
        alert.setView(v);
        // В файле макета dialog_layout.xml есть RadioGroup который содержит 3 RadioButton
        // через RadioGroup получить информацию о выбранном RadioButton легче, потому что
        // в данном случае обработчик изменения выбора подключается только к RadioGroup
        RadioGroup group = v.findViewById(R.id.group);
        // Подключить обработчик при изменении выбранного элемента внутри RadioGroup
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Получить id выбранной кнопки и по id получить ссылку на выбранную радио кнопку
                RadioButton rb = v.findViewById(group.getCheckedRadioButtonId());
                // Показать сообщение с текстом и id выбранной кнопки
                Toast.makeText(getContext(), "Выбрана кнопка " + rb.getText() + checkedId, Toast.LENGTH_SHORT).show();
            }
        });
        // Устанавливает кнопку подтверждения и обработчик события клик для кнопки
        alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getContext(), "Positive button clicked", Toast.LENGTH_SHORT).show();
                // Закрыть диалоговое окно функцией dismiss();
                dismiss();
            }
        });
        // Устанавливает кнопку отклонения и обработчик события клик для кнопки
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });

        // Вернуть экземпляр диаологового окна для показа
        return alert.create();
    }
}
