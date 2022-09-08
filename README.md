kratko objasnjenje sta je u kom fajlu
main klasa poziva heightcomparator sa razlicitim greskama i hvata u catch bloku ispod catch bloka nalazi se komentarisan nameno izazvani index outof bounds checked exc
height komparator uporedjuje visine ljudi i validira unose preko height validatora
height validator prima gornju i donju granicu i proverava da li je visina validna (podrazumevane granice su visina odraslog coveka)
height validator test testira height validator
height komparator test koristi mockovani height validator i testira komparator
