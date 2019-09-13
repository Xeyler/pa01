pdf: timings.csv
	pandoc -o writeup.pdf writeup.md

timings.csv:
	gradle run -p ../code/ -q --args="200000" > timings.csv

.PHONY: clean
clean:
	rm -f writeup.pdf timings.csv
