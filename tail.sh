FILE=$1

echo "How many lines?: "
read HowMany

echo "Heads or tails? "
read HoT
case "$HoT" in
  h) awk 'NR <= '$HowMany $FILE ;;
  t) awk 'NR > '$(($(wc -l < $FILE) - $HowMany)) $FILE
esac
