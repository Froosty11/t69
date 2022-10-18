set terminal pdf
set termoption enhanced
set datafile separator "\t"
set output "UsingCurrentString.pdf"

set title "Average time building dictionary using current word"

set key left top

set xlabel "n"
set ylabel "time (ns)"


plot "data1.dat" using 1:2 with linespoints title "currentString", \
     "data2.dat" using 1:2 with linespoints title "no currentString", \