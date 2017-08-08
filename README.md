# projetomc

Pré-requisitos:
<li>Bash do linux
<li>Maven (Comando mvn -> pacote maven)
<li>Java sdk (Comando java -> pacote default-jre)

Instruções para executar:
<li>1) Clonar o repositório;
<li>2) No bash do linux ir para a pasta do projeto (projetomc)
<li>3) Executar o comando ./ordenar.sh $1 $2 $3 $4 $5 $6

Parâmetros:
$1 = sort_m1 | dataset_gen

Usar sort_m1 para realizar o sort em um dataset. Usar dataset_gen para gerar um dataset aleatório que segue as características passadas como parâmetro.

sort_m1:
<li>$2 = quick | merge | insertion;
<li>$3 = Path do dataset de entrada (caminho para um arquivo .csv);
<li>$4 = Path do arquivo onde será guardado os dados da execução (caminho para um arquivo .csv);
<li>$5 = ascending | descending (Ordem na qual o algoritimo deixará os elementos ordenados);
<li>$6 = Número inteiro maior ou igual a 0 representando a quantidade de replicações (0 para nenhuma).

dataset_gen:
<li>$2 = Nome do arquivo a ser gerado (deve terminar com .csv);
<li>$3 = ascending | descending | none (Ordem na qual o dataset será ordenado);
<li>$4 = all | none (Quantidade de elementos que já estarão ordenados);
<li>$5 = Número inteiro maior ou igual a 0 representando o tamanho de cada array que será gerado.
<li>$6 = Número inteiro maior ou igual a 0 representando a quantidade de array que serão gerados.

EXEMPLOS:
./ordenar.sh 

Obs.: | = Ou exclusivo
mvn clean install;java -cp ./target/classes ufcg.metodologia.projetomc.Main sort_m1 merge datasets/milestone1/dataset1.csv output/output1.csv ascending 10
