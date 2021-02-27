// Smooth scroll (jump) effect
const links = document.querySelectorAll("#scroll");
for(const link of links){
    link.addEventListener("click", clickHandler)
}

function clickHandler(event){
    const href = this.getAttribute("href");
    const offsetTop = document.querySelectorAll(href).offsetTop;

    scrollTo({
        top: offsetTop,
        behavior: "smooth"
    });
}
