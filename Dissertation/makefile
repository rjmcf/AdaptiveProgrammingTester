# This is the makefile for the Part II demonstration dissertation
#
# Note that continuation lines require '\' and
# that a TAB character preceeds any shell command line

.DELETE_ON_ERROR:

# Rules for building LaTeX documents (see Unix Tools course)
%.pdf %.aux %.idx: %.tex
	pdflatex -halt-on-error $<
	while grep 'Rerun to get ' $*.log ; do pdflatex $< ; done
%.ind: %.idx
	makeindex $*
%.bbl: %.aux
	bibtex $*
# Rules for exporting xfig diagrams into PDF or EPS
%.pdf: %.eps
	pstopdf $< -o $@
%.eps: %.fig
	fig2dev -L eps $< $@
%.pdftex %.pdftex_t: %.fig
	fig2dev -L pdftex_t -p $*.pdftex $< $*.pdftex_t
	fig2dev -L pdftex $< $*.pdftex

help:
	@echo
	@echo "USAGE:"
	@echo
	@echo "make                display help information"
	@echo "make proposal.pdf   format the proposal as PDF"
	@echo "make diss.pdf       format the dissertation as PDF"
	@echo "make all            make proposal.pdf and diss.pfd"
	@echo "make clean          delete all intermediate files"
	@echo

diss.pdf: proposal.tex diss.bbl

all: proposal.pdf diss.pdf

clean:
	rm -f *.aux *.log *.err *.out
	rm -f *~ *.lof *.toc *.blg *.bbl
	rm -f makefile.txt

distclean: clean
	rm -f figs/*.pdf proposal.pdf diss.pdf
