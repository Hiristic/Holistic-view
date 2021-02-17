
interface BoxContract {

  //Page class will act as the view
  interface View {
    fun showBoxes(boxes: List<Box>)
    fun showLoader()
    fun hideLoader()
  }
  //Presenter class will contain all logic
  interface Presenter {
    fun attach(view: View)
    fun loadBoxes()
    fun loadLocalBoxes()
  }
}
