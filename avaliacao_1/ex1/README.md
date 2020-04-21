# Exercício 1

O objetivo do exercício um é implementar um contador compartilhado que deverá ser exposto através de TCP/IP. O cliente que irá consumir o serviço já está implementado na classe SharedCounterClient e SharedCounterClientRunnable. Completem a implementação do servidor, lembrem de atentar para o fato do acesso concorrente à estrutura que irá oferecer o serviço de contador de forma a impedir que acessos concorrentes resultem em valores idênticos retornados à mais de uma requisição.
