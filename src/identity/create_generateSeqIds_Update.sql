CREATE PROCEDURE "dbo"."generateSeqIds_Update" @idtype varchar(100) AS

declare @curid char(20)
declare @rawval bigint
declare @mask char(20)
declare @start int
declare @end int


SET NOCOUNT ON

update dbo.idSequence 
set 
rawval = rawval + 1,

currentid = 
		substring(
			rtrim(idmask), 
			1, 
			charindex('#', idmask) -1) 
		+ 
		replicate(
			'0', 
			len(rtrim(idmask)) - charindex('#', ltrim(reverse(idmask)) ) + 2 - charindex('#', idmask) - len(rawval + 1))
		+ 
		convert(char(20), rawval + 1) 
		+ 
		substring(
			rtrim(idmask), 
			len(rtrim(idmask)) - charindex('#', ltrim(reverse(idmask))) + 2, 
			(len(rtrim(idmask)) - len(rtrim(idmask)) - charindex('#', ltrim(reverse(idmask))) + 2) + 1),
			
@rawval = rawval,
@curid = currentid,
@mask = idmask
where idtype = @idtype



set @rawval = @rawval + 1
set @start = charindex('#', @mask)
set @end =  len(rtrim(@mask)) - charindex('#', ltrim(reverse(@mask))) + 2


SET NOCOUNT OFF


select id = convert(char(20), substring(rtrim(@mask), 1, @start -1) + replicate('0', @end - @start - len(@rawval)) + convert(char(20), @rawval) + substring(rtrim(@mask), @end, (len(rtrim(@mask)) - @end) + 1))
