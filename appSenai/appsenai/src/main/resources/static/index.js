const user = document.getElementById("form")
const tabelaPessoa = document.getElementById("tabelaPessoas").getElementsByTagName('tbody')[0];
const btnAll = document.getElementById("listarPessoas");
const btnDelete = document.getElementById("excluir");


user.addEventListener("submit", function (even) {
    even.preventDefault();
    let formDados = new FormData(user);
    let parametros = new URLSearchParams(formDados);

    
    fetch("/person?" + parametros.toString(), {
        method: "POST"

    }).then(response => response.json())
        .then(data => {
            document.getElementById("id").value = data.id;
        })



   
});
btnAll.addEventListener("click", function () {

    fetch("/all")
        .then(response => response.json())
        .then(data => {
            tabelaPessoa.innerHTML = "";
            data.forEach(pessoa => {
                let row = tabelaPessoa.insertRow();
                row.insertCell(0).textContent = pessoa.id;
                row.insertCell(1).textContent = pessoa.name;
                row.insertCell(2).textContent = pessoa.sexo;
            })

        })

});



btnDelete.addEventListener("click", function () {
    fetch("/person?name=" + document.getElementById("name").value, {
        method: "Delete"
    }).then(response => response.json())

    

});