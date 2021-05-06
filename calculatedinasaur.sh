#Question 1:
#You will be supplied with two data files in CSV format .
#The first file contains statistics about various dinosaurs. The second file contains additional data.
#Given the following formula, speed = ((STRIDE_LENGTH / LEG_LENGTH) - 1) * SQRT(LEG_LENGTH * g)
#Where g = 9.8 m/s^2 (gravitational constant)

names=`cat names.dat`
for n in $names
do
stride=`cat dataset2.csv | grep -v NAME | grep -i $n | cut -d "," -f2`
length=`cat dataset1.csv | grep -V NAME | grep -i $n | cut -d "," -f2`
echo $length
echo printf %.10f\\n "$((stride/length))e-9"
#awk "BEGIN {print ($stride/$length)-1}"
echo $value
echo $stride","$n
done
