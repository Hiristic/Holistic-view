import org.w3c.dom.HTMLDivElement
import kotlinx.browser.document

//Page class will act as the view
class BoxPage(private val presenter: BoxContract.Presenter) : BoxContract.View {

  private val loader = document.getElementById("loader") as? HTMLDivElement ?: throw RuntimeException("The DOM has no 'loader' id")
  private val content = document.getElementById("content") as? HTMLDivElement ?: throw RuntimeException("The DOM has no 'content' id")

  private val cardBuilder = CardBuilder()

 // fun show() {
 //   presenter.attach(this)
 //   presenter.loadBoxes()
  //}

  override fun showBoxes(boxes: List<Box>) {
    boxes.forEach { box ->
      val card = cardBuilder.build(box)
      content.appendChild(card)
    }
  }

  override fun showLoader() {
    loader.style.visibility = "visible"
  }

  override fun hideLoader() {
    loader.style.visibility = "hidden"
  }
}
