<xsl:stylesheet   version="2.0"   xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="text" encoding="iso-8859-1" version="4.0" indent="yes" media-type="text/plain"/>    


<xsl:template match="tables">
    <xsl:for-each select="table[not(@idGenerateIgnore='true')]">        
	  <xsl:variable name="PREFIX">
	    <xsl:choose>
		  <xsl:when test="@twoCharAbbr">D<xsl:value-of select="@twoCharAbbr"/></xsl:when>
		  <xsl:otherwise>DEV</xsl:otherwise>
		</xsl:choose>
	  </xsl:variable>

@echo <xsl:value-of select="node()"/>;
declare @existingKey int	
set @existingKey = (select count(*) from dbo.idSequence where (idtype = '<xsl:value-of select="node()"/>'))

if (@existingKey = 0)
BEGIN
	INSERT INTO dbo.idSequence    ( idtype,  startid,  currentid, idmask,  createid, createdate,  updateid, lastupdate, rawval)
	    VALUES    (
	        '<xsl:value-of select="node()"/>',   '<xsl:value-of select="$PREFIX"/>00000000000000000',  '<xsl:value-of select="$PREFIX"/>00000000000000000',  '<xsl:value-of select="$PREFIX"/>#################',
	        'direct sql', GETDATE(), 'direct sql', GETDATE(), 0)
END;
	        
    </xsl:for-each>
</xsl:template>

</xsl:stylesheet>
