
import android.content.Context
import android.widget.Toast

/**
 * Created by Ashish on 9/11/2017.
 */
fun Context.showToast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()