package android.mvvm.starter.base.databinding;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.widget.EditText;

public class DataBindingAdapter {
    @BindingAdapter("passwordValidator")
    public static void passwordValidator(EditText editText, String password) {
        // ignore infinite loops
        int minimumLength = 5;
        if (TextUtils.isEmpty(password)) {
            editText.setError(null);
            return;
        }
        if (editText.getText().toString().length() < minimumLength) {
            editText.setError("Password must be minimum " + minimumLength + " length");
        } else editText.setError(null);
    }
}
