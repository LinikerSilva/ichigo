<h1 align="center">Ichigo</h1>

> Ichigo Kurosaki é um personagem fictício e protagonista da série de mangá Bleach e suas adaptações criado por Tite Kubo. Ichigo adquiriu poderes de shinigami logo após o encontro com Rukia Kuchiki, uma shinigami encarregada de patrulhar a sua cidade, a cidade fictícia de Karakura. Como Shinigami, Ichigo purifica os Hollows de sua cidade, convertendo-os em seus formatos originais na Soul Society, tal como este projeto converte um arquivo .txt em um .json.

<img alt="ichigo-image" src="https://i.pinimg.com/originals/b8/fb/4c/b8fb4c35f15dc340ed63accb39f6875e.jpg">

## Descrição do Projeto
* Fazer a conversão de um arquivo .txt com uma determinada formatação para um arquivo .json.
####
* Foi criado num desafio de backend nível júnior durante meu período de trabalho como jovem aprendiz no LuizaLabs.

## Como Executar Este Projeto
* É necessário Java 17 para executar este projeto.
####
* É necessário Maven 3.6.3 ou acima para executar este projeto.
####
* É necessário ter na máquina, em algum local, um diretório com o arquivo .txt no formato determinado, pelo qual a aplicação se baseia para processar, conforme este exemplo de arquivo .txt: https://drive.google.com/file/d/18qIHrzNVnczVVTmpJF2YYwppKOgz26uk/view?usp=sharing
####
* Uma vez que atenda aos requisitos anteriores, pode clonar ou baixar o projeto.
####
* Após clonar ou baixar o projeto em sua máquina, é necessário compilá-lo com sua IDE de preferência (comando: mvn clean install). 
####
* Uma vez compilado, é necessário rodar o projeto com base no .jar gerado, passando como argumento o caminho do diretório onde está o arquivo .txt em sua máquina.
Para isso, precisamos entrar no diretório onde o arquivo .jar gerado está localizado. Normalmente este diretório é o target, dentro dos arquivos do projeto. É importante salientar que o caminho do arquivo .txt deve estar entre aspas "" (comando: java -jar ichigo-1.0-SNAPSHOT-jar-with-dependencies.jar "caminhoDoArquivoTxt").
####
* Se todos os passos forem seguidos corretamente e o caminho do diretório for válido, existente e sem erros de escrita, então o projeto executará sem problemas.


