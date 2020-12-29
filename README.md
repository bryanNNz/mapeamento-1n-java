## Mapeamento 1-N

Trata-se de uma implementação de mapeamento 1-N utilizando JPA e H2 para simular a base de dados com base no mapeamento das classes.

## Tecnologias

[Spring](https://github.com/spring-projects/spring-boot) - Para construção dos serviços
<br />
[Lombok](https://github.com/rzwitserloot/lombok) - Muito útil para redução de código
<br />
[H2](https://github.com/h2database/h2database) - Para banco de dados em memória
<br />
[Jackson Annotations](https://github.com/FasterXML/jackson-annotations) - Para configurações relativas a JSON

## Recursos

| Verbo | Recurso |
| ----- | ------- |
| GET | /rest/pessoas |
| GET | /rest/pessoa/{id} |
| GET | /rest/telefones |
| GET | /rest/telefone/{id} |
| GET | /rest/telefonesByPessoa/{id} |