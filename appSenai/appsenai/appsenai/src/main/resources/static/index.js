const user = document.getElementById(id)

user.addEventListener("submit" , function(even){
    even.preventDefault();
   
    let parametros = new URLSearchParams(user);
    let nome = document.getElementById("nome").value;
    document.getElementById("sexo").value = nome;




    const tabelaPessoa = document.getElementById("tabelaPessoas")
    .getElementsByTagName('tbody')[0];


    const btnAll = document.getElementById("listarPessoas");






btnAll.addEventListener("click", function (){
    fetch("/all")
        .then(response => response.json())
        .then(data => {
            tabelaPessoa.innerHTML ="";
            data.forEach(pessoa => {
                let row= tabelaPessoa.insertRow();
                row.insertCell(0).textContent = pessoa.id;
                row.insertCell(1).textContent = pessoa.name;
                row.insertCell(2).textContent = pessoa.sexo;
            })

    })

});







    fetch("/person?"+parametros.toString(),{
        method: "POST"

    }).then(response => response.json())
        .then(data => {
            document.getElementById("id").value = data.id;
        })
});