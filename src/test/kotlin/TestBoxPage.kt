import kotlinx.browser.document
import org.w3c.dom.HTMLDivElement
import kotlin.test.Test
import kotlin.test.assertEquals

class TestBoxPage {
    @Test
    fun testContentElement() {
        assertEquals(HTMLDivElement, document.getElementById("content"))
    }
} 