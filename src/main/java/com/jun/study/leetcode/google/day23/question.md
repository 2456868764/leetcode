# Question:
Got this question

Given a patch with list of replacements, apply the patch
```
Replacement{
int offset; starting offset of the change
String previousString; - string present from starting offset
String newString - this string should replace previous string
}

Patch{
List replacements
void apply(String org){
// Write code to apply the replacements
}
}
```

We need to check for valid of the replacement. like if the previousString is actually the same at the offset mentioned in the org string.
Sort the replacement wrt to offset so that they ar eall in order

After that I just used brute force and applied stringbuilder replace.

Interviewer said try thinking of String Buffer or having a buffer to have the replacements.

I did tno understand this. Can anyone else opine here?