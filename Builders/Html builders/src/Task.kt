fun renderProductTable(): String {
    return html {
        table {
            tr(getTitleColor()) {
                td {
                    text("Product")
                }
                td {
                    text("Price")
                }
                td {
                    text("Popularity")
                }
            }
            val products = getProducts()
            tr {
                td(getCellColor(0, 0)) {
                    text(cactus.description)
                }
                td (getCellColor(1, 0)){
                    text(cactus.price)
                }
                td (getCellColor(2, 0)){
                    text(cactus.popularity)
                }
            }
        }
    }.toString()
}

fun getTitleColor() = "#b9c9fe"
fun getCellColor(index: Int, row: Int) = if ((index + row) % 2 == 0) "#dce4ff" else "#eff2ff"
