submission: writeup/writeup.pdf
	mkdir -p submission
	cp writeup/writeup.pdf code/answers.pdf
	cd code/ && zip -r brigham_campbell.zip . && rm answers.pdf
	mv code/brigham_campbell.zip submission/brigham_campbell.zip

writeup/writeup.pdf:
	$(MAKE) -C writeup/

.PHONY: clean
clean:
	rm -f submission/brigham_campbell.zip
	$(MAKE) clean -C writeup/
