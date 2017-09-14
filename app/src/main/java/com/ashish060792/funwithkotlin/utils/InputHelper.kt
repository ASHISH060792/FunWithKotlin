
import android.support.design.widget.TextInputLayout
import android.text.TextUtils
import android.widget.EditText
import android.widget.TextView

/**
 * Created by Ashish on 9/11/2017.
 */
object InputHelper {

    val SPACE = "\u202F\u202F"

    private fun isWhiteSpaces(s: String?): Boolean {
        return s != null && s.matches("\\s+".toRegex())
    }

    fun isEmpty(text: String?): Boolean {
        return text == null || TextUtils.isEmpty(text) || isWhiteSpaces(text) || text.equals("null", ignoreCase = true)
    }

    fun isEmpty(text: Any?): Boolean {
        return text == null || isEmpty(text.toString())
    }

    fun isEmpty(text: EditText?): Boolean {
        return text == null || isEmpty(text.text.toString())
    }

    fun isEmpty(text: TextView?): Boolean {
        return text == null || isEmpty(text.text.toString())
    }

    fun isEmpty(txt: TextInputLayout?): Boolean {
        return txt == null || isEmpty(txt.editText)
    }

    fun toString(editText: EditText): String {
        return editText.text.toString()
    }

    fun toString(editText: TextView): String {
        return editText.text.toString()
    }

    fun toString(textInputLayout: TextInputLayout): String {
        return if (textInputLayout.editText != null) toString(textInputLayout.editText!!) else ""
    }

    fun toNA(value: String?): String? {
        return if (isEmpty(value)) "N/A" else value
    }

    fun toString(`object`: Any?): String {
        return if (!isEmpty(`object`)) `object`!!.toString() else ""
    }

    fun toLong(textView: TextView): Long {
        return toLong(toString(textView))
    }

    fun toLong(text: String): Long {
        if (!isEmpty(text)) {
            try {
                return java.lang.Long.valueOf(text.replace(".", "").replace(",".toRegex(), ""))!!
            } catch (ignored: NumberFormatException) {
            }

        }
        return 0
    }


    fun getSafeIntId(id: Long): Int {
        return if (id > Integer.MAX_VALUE) (id - Integer.MAX_VALUE).toInt() else id.toInt()
    }

    fun capitalizeFirstLetter(s: String): String {
        if (isEmpty(s)) {
            return ""
        }
        val first = s[0]
        return if (Character.isUpperCase(first)) {
            s
        } else {
            Character.toUpperCase(first) + s.substring(1)
        }
    }
}
