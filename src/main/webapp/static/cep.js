function buscarEndereco() {
    const cep = document.getElementById("cep").value;

    if (!/^\d{8}$/.test(cep)) {
        alert("CEP inválido. Digite exatamente 8 números.");
        return;
    }

    fetch(`/cep/${cep}`)
        .then(response => {
            if (!response.ok) throw new Error("CEP não encontrado.");
            return response.json();
        })
        .then(data => {
            document.getElementById("neighbourhood").value = data.bairro || '';
            document.getElementById("city").value = data.localidade || '';
        })
        .catch(error => {
            alert("Erro ao buscar CEP: " + error.message);
        });
}
