package org.vanilladb.core.query.algebra;

import org.vanilladb.core.sql.Constant;
import org.vanilladb.core.sql.Type;
import org.vanilladb.core.sql.VarcharConstant;

public class ExplainScan implements Scan {
	private Scan s;
	private boolean hasExplained = false;
	
	public ExplainScan(Scan s) {
		this.s = s;
	}

	@Override
	public Constant getVal(String fldName) {
		// TODO Auto-generated method stub
		String explain_str = "\n\n" + s.TraverseScanForMeta(1);
		return new VarcharConstant(explain_str, Type.VARCHAR(500));
	}

	@Override
	public void beforeFirst() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean next() {
		if(!this.hasExplained) {
			this.hasExplained = true;
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		s.close();
	}

	@Override
	public boolean hasField(String fldName) {
		// TODO Auto-generated method stub
		if(fldName == "plan-query")
			return true;
		else
			return false;
	}

	@Override
	public String TraverseScanForMeta(int level) {
		// TODO Auto-generated method stub
		return "";
	}

}
