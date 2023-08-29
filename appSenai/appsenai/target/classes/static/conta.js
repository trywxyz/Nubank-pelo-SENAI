const formConta = document.getElementById("formConta");
const tabelaPessoas = document.getElementById("tabelaPessoas").getElementsByTagName("" +'tbody')[0];
const btnAll = document.getElementById("listarPessoas");
const btnCriar = document.getElementById("criar")




document.addEventListener("DOMContentLoaded", function (){
    let comboPessoa = document.getElementById("pessoa");
    function preencherPessoa(){
        fetch("/all")
            .then(response => response.json())
            .then(data => {
                let option = document.createElement("option");
                option.value = null;
                option.textContent = "";
                comboPessoa.appendChild(option);
                data.forEach(pessoa => {
                    let option = document.createElement("option");
                    option.value = pessoa.id;
                    option.textContent = pessoa.name;
                    comboPessoa.appendChild(option);
                })

            })
    }
    preencherPessoa();
});




btnCriar.addEventListener("click", function (event) {
    event.preventDefault();
    let formDados = new FormData(formConta);
    let parametros = new URLSearchParams(formDados);

    fetch("/criarconta", + parametros.toString(),{
        method: "POST"
    }).then(response => response.json())
        .then(data => {
            document.getElementById("id").value = data.id;
            document.getElementById("tipo_conta").value = data.type;
        })
});




btnAll.addEventListener("click", function (){
    fetch("/all")
        .then(response => response.json())
        .then(data => {
            tabelaPessoas.innerHTML="";
            data.forEach(conta => {
                let row = tabelaPessoas.insertRow();
                row.insertCell(0).textContent = conta.id;
                row.insertCell(1).textContent = conta.name;
                row.insertCell(2).textContent = conta.numero_conta;
                row.insertCell(3).textContent = conta.type;
                
            })
        })
});

