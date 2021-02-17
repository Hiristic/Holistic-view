import kotlinx.browser.document
import org.w3c.dom.DocumentReadyState
import org.w3c.dom.LOADING


//val API_URL = js("getApiUrl()") as String

//val API_URL = "selection.js"
val API_URL = "https://gist.githubusercontent.com/tarek360/4578e33621011e18829bad0c8d1c8cdf/raw/06d185bebc3e14a56dfa85f53288daddd4ff6a2b/books.json"
fun main() {
    document.write("Hello, jello")
    document.bgColor = "gray"

    println("Staaaarting")
    println(API_URL)


    waitUntilDomIsLoaded()

}

//Wait to run initialization code until the DOM is fully loaded.
private fun waitUntilDomIsLoaded() {
    if (document.readyState == DocumentReadyState.LOADING) {
        document.addEventListener("DOMContentLoaded", {
            console.log("DOM fully loaded and parsed")
            afterLoaded()
        })
    } else {
        //The DOMContentLoaded event has already fired. Just run the code.
        console.log("DOM was already fully loaded")
        afterLoaded()
    }
}

fun afterLoaded() {
    //Your initialization code goes here. This is from where your code should start
    //  running if it wants to access elements placed in the DOM by your HTML files.
    //  If you are wanting to access DOM elements inserted by JavaScript, you may need
    //  to delay more, or use a MutationObserver to see when they are inserted.

    val boxPresenter = BoxPresenter()
    println("boxPresenter created")
    //boxPresenter.loadLocalBoxes()
    val boxPage = BoxPage(boxPresenter)
    println("boxPage created")
    boxPresenter.attach(boxPage)
    println("boxPresenter attached boxPage")
    boxPresenter.loadBoxes()
    println("boxPresenter loadBoxes")
}