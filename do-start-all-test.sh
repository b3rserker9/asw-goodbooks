echo
echo "===== Inizializzazione dei database ====="

# Inizializzazione Recensioni
echo
echo "do-init-recensione.sh"
./do-init-recensioni.sh


# Inizializzazione connessioni
echo
echo "do-init-connessioni.sh"
./do-init-connessioni.sh


## Get methods
echo
echo "===== Test dei metodi di GET ====="

echo
echo "do-get-recensioni.sh"
./do-get-recensioni.sh

echo
echo "do-get-connessioni.sh"
./do-get-connessioni.sh

# Get recensioni seguiti da Utente
echo "----- Recensioni seguiti da {Utente} -----"
echo
echo "do-get-recensioni-seguiti Alice"
./do-get-recensioni-seguiti.sh Alice
echo
echo "do-get-recensioni-seguiti Barbara"
./do-get-recensioni-seguiti.sh Bob
echo
echo "do-get-recensioni-seguiti Carlo"
./do-get-recensioni-seguiti.sh Carlo
echo


# Get recensioni per autore/recensore/titolo
echo "----- recensioni per {Tipo} -----"
echo
echo "do-get-recensioni-per-autore"
./do-get-recensioni-per-autore.sh Tolstoj
echo
echo "do-get-recensioni-per-recensore"
./do-get-recensioni-per-recensore.sh Woody
echo
echo "do-get-recensioni-per-titolo"
./do-get-recensioni-per-titolo.sh "I promessi sposi"
echo


echo
echo "do-get-connessioni-per-utente"
./do-get-connessioni-per-utente.sh Bob
echo