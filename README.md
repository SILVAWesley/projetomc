# projetomc

Pré-requisitos:
<li>Bash do linux
<li>Git (Comando git)
<li>Maven (Comando mvn)
<li>Java sdk (Comando java)

Instruções para executar:
<li>1) Clonar o repositório;
<li>2) No bash do linux ir para a pasta do projeto (projetomc)
<li>3) Executar o comando ./ordenar.sh $1 $2 $3 $4 $5 $6

Parâmetros:
$1 = sort_m1 | dataset_gen

mvn clean install;java -cp ./target/classes ufcg.metodologia.projetomc.Main sort_m1 merge datasets/milestone1/dataset1.csv output/output1.csv ascending 10
