import org.w3c.files.File
import org.w3c.xhr.XMLHttpRequest
//import java.io.File

//Presenter class will contain all of the logic
class BoxPresenter : BoxContract.Presenter {

  private lateinit var view: BoxContract.View

  override fun attach(view: BoxContract.View) {
    this.view = view
  }

  override fun loadLocalBoxes() {
    //view.showLoader()
    println("boxPresenter.loadLocalBoxes")
    //val filename = "./src/main/assets/selection.json"
    //val file = File(filename)
    //val jsonString: String = file.readText(Charsets.UTF_8)
    //val jsonString: String = File(filename).readText(Charsets.UTF_8)
    //val boxes = JSON.parse<Array<Box>>(jsonString)


    //  val boxes = JSON.parse<Array<Box>>(response)

      //FIXME remove debug printout
   //   boxes.forEach {
   //     println(it.title)
   //   }

    //view.hideLoader()
    //view.showBoxes(boxes.toList())
  }


  override fun loadBoxes() {
    view.showLoader()

    getAsync(API_URL) { response ->
      val boxes = JSON.parse<Array<Box>>(response)

      //FIXME remove debug printout
      boxes.forEach {
        println(it.title)
      }

      view.hideLoader()

      view.showBoxes(boxes.toList())
    }
  }

  private fun getAsync(url: String, callback: (String) -> Unit) {
    val xmlHttp = XMLHttpRequest()
    xmlHttp.open("GET", url)

    xmlHttp.onload = {
      if (xmlHttp.readyState == 4.toShort() && xmlHttp.status == 200.toShort()) {
        callback.invoke(xmlHttp.responseText)
      }
    }
    xmlHttp.send()
  }
}
