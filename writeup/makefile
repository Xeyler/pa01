pdf: timings.csv
	pandoc -o writeup.pdf writeup.md

timings.csv:
	gradle run -p ../project/ -q --args="200000" > timings.csv

.PHONY: clean
clean:
	rm writeup.pdf timings.csv
