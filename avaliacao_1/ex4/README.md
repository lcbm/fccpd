# Exercício 4

No exercício quatro o objetivo é implementar o padrão produtor-consumidor. O projeto conta com duas Threads, uma responsável por fazer o papel do produtor e uma segunda do consumidor. Implementem a classe ProducerConsumerImpl de forma que:

1) a Thread produtora interrompa a execução sempre que o buffer for preenchido;
2) a Thread produtora seja retomada assím que houver espaço no buffer;
3) a Thread consumidora interrompa a execução sempre que o buffer estiver vazio;
4) a Thread consumidora retome a execução assim que houver ítens no buffer;
