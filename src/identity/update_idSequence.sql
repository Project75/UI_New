update idSequence
set 
startid = 'Q' + substring(startid, 2, len(startid))
, currentid = 'Q' + substring(currentid, 2, len(currentid))
, idmask = 'Q' + substring(idmask, 2, len(idmask))
from idSequence


select * from idsequence



