# Exercício 2

Neste projeto, a classe Main utiliza de Busy-Wait para detectar a conclusão. Quais as implicações dessa implementação e quais as alternativas?

R: _Busy waiting_ é considerado um anti-padrão é porque utiliza loops vazios (_NOOPS_) enquanto a outra thread não termina sua tarefa. Algumas das implicações dessa abordagem são: 1) baixa performance (gasta ciclos de CPU e segura recursos); 2) condição de corrida; 3) _starvation_. No exemplo do código, a thread demora 1 minuto para terminar a tarefa e, nesse meio tempo, outros processos podem precisar de recursos que nsó poderão ser obtidos uma vez que a thread terminar de executar a tarefa. Além disso, não há um mecanismo de fila para ordenar quais processos solicitaram quando quais recursos -- incluindo processos que entraram nas suas seções criticas ou que têm maior prioridade.

Algumas das alternativas para _busy waiting_ são: semáforos, monitores, mutex (locks). Essas abordagens podem ser utilizadas em conjunto para resovler problemas de condição de corrida, assim como problemas de seção crítica e sincronização.
