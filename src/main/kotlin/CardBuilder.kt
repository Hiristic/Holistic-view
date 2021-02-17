import org.w3c.dom.*
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.dom.addClass

class CardBuilder {

    fun build(box: Box): Element {
        val containerElement = document.createElement("div") as HTMLDivElement
        val imageElement = document.createElement("img") as HTMLImageElement
        val titleElement = document.createElement("div") as HTMLDivElement
        val descriptionElement = document.createElement("div") as HTMLDivElement
        val viewDetailsButtonElement = document.createElement("button") as HTMLButtonElement

        // bind data
        bind(box = box,
            imageElement = imageElement,
            titleElement = titleElement,
            descriptionElement = descriptionElement,
            viewDetailsButtonElement = viewDetailsButtonElement)

        // apply styles
        applyStyle(containerElement,
            imageElement = imageElement,
            titleElement = titleElement,
            descriptionElement = descriptionElement,
            viewDetailsButtonElement = viewDetailsButtonElement)

        containerElement
            .appendChild(
                imageElement,
                titleElement,
                descriptionElement,
                viewDetailsButtonElement
            )
        return containerElement
    }

    // Apply CSS Classes
    private fun applyStyle(containerElement: HTMLDivElement,
                           imageElement: HTMLImageElement,
                           titleElement: HTMLDivElement,
                           descriptionElement: HTMLDivElement,
                           viewDetailsButtonElement: HTMLButtonElement) {

        containerElement.addClass("card", "card-shadow")
        imageElement.addClass("cover-image")
        titleElement.addClass("text-title", " float-left")
        descriptionElement.addClass("text-description", " float-left")
        viewDetailsButtonElement.addClass("view-details", "ripple", "float-right")
    }

    // Bind data to the view
    private fun bind(box: Box,
                     imageElement: HTMLImageElement,
                     titleElement: HTMLDivElement,
                     descriptionElement: HTMLDivElement,
                     viewDetailsButtonElement: HTMLButtonElement) {

        imageElement.src = box.coverUrl

        titleElement.innerHTML = box.title
        descriptionElement.innerHTML = box.description
        viewDetailsButtonElement.innerHTML = "GO TO"

        viewDetailsButtonElement.addEventListener("click", {
            window.open(box.url)
        })
    }

    private fun Element.appendChild(vararg elements: Element) {
        elements.forEach {
            this.appendChild(it)
        }
    }
}
