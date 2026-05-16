BEANS!!!! funcionou. 
Tambem so percebi agora que esqueci de colocar @Service em alguns das classes dentro do package service. 
Tentei usar dto com Beans, mas não consegui, então foi por model mesmo.
Alguns IDs ficaram nulls mesmo e alguns pacientes e consultas dentro dos proprios models (como medico, convenio e etc).
Eu optei por usar Swagger porque é mais facil testar ele do que Postman, mas tive que reverter a versão do Spring para 3.5.14, em vez de 4.0.6.

Response body de bean-controller GET (no Swagger):
{
  "id": null,
  "nome": "Paciente Padrão",
  "cpf": "1234-5678-10",
  "telefone": "1111-2222",
  "prontuario": {
    "id": null,
    "tipoSanguineo": "P+",
    "alergia": "Alergia Padrão",
    "observacoes": "Observações Teste"
  },
  "consultas": [
    {
      "id": 1,
      "dataHora": "2023-04-27",
      "motivo": "Motivo padrão",
      "valor": 10,
      "paciente": null,
      "medico": {
        "id": 1,
        "nome": "Medico Padrão",
        "especialidade": "Especialidade Padrão",
        "crm": "CRM Padrão",
        "consultas": null
      },
      "convenio": {
        "id": 1,
        "nome": "Covenio Padrão",
        "cnpj": "CNPJ Padrão",
        "consultas": null
      },
      "receita": {
        "id": 1,
        "medicamento": "Medicamento Padrão",
        "dosagem": "Dosagem Padrão",
        "duracaoDias": 4,
        "consulta": null
      }
    }
  ]
}
