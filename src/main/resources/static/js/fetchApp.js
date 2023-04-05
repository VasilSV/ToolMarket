let loadToolTypeBtn= document.getElementById("loadTools")
loadToolTypeBtn.addEventListener('click', reloadToolType)
console.log(loadToolTypeBtn)
// TODO: create new book

function reloadToolType() {
    console.log('button is clicked')

    let toolsTypeCntr = document.getElementById('tools-container')
    //toolsTypeCntr.innerHTML = ''

    let  requestOption ={
        method: 'GET'
    }
    fetch("http://localhost:8080/api/tools", requestOption).
    then(response => response.json()).
    then(json => json.forEach(toolType => {
        // create row
        let row = document.createElement('tr')

        let typeCool = document.createElement('td')
        typeCool.textContent= toolType.title
        row.appendChild(typeCool)
        toolsTypeCntr.appendChild(row)

    }))


}