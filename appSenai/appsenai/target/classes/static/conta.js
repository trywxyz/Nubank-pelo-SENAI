document.addEventListener("DOMContentLoaded", function () {

    let comboPessoa = document.getElementById("pessoa")


    function preenchePessoa() {

        fetch("/all")
            .then(response => responde.json())
            .then(data => {
                data.array.forEach(pessoa => {
                    let option = document.createElement("option")
                    option.value = pessoa.id
                    option.textContent = pessoa.name
                    comboPessoa.appendChild(option)



                });
            })
    }

    preenchePessoa()

})