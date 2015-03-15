# crazy_date_calculations
A little crazy program that takes a String with a query to convert come date info and tries to interpret and answer it (approximately).

This code assumes 365 days for a year and 30 days for a month.

Currently, the only kind of input that gets answered is of the pattern:

> [quantos, quantas...] <x> [há em, tem, ...] <period>

* <x> can be: segundos, minutos, horas, dias, semanas, meses, anos (case-sensitive, but singular/plural doesn't matter).
* Text between `[]` is optional.
* <period> can be things like: 10 anos, 20 meses, 2 semanas e 15 dias...

**This is experimental code.**
