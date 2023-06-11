package www.ezriouil.tvmaze.util

fun String.removeHTMLTags(): String{
    return Regex(pattern = "<\\w+>|</\\w+>").replace(input = this, replacement = "")
}