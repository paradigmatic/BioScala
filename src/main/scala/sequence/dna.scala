package bio

import bio.symbols.dna.Nucleotide

class DNA( name: String, dnaSeq: List[Nucleotide] )
extends Sequence[Nucleotide](name,dnaSeq)
