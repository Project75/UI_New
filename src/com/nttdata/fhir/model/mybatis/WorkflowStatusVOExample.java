package com.nttdata.fhir.model.mybatis;

import java.util.ArrayList;
import java.util.List;

public class WorkflowStatusVOExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table workflowstatus
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table workflowstatus
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table workflowstatus
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table workflowstatus
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public WorkflowStatusVOExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table workflowstatus
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table workflowstatus
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table workflowstatus
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table workflowstatus
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table workflowstatus
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table workflowstatus
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table workflowstatus
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table workflowstatus
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table workflowstatus
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table workflowstatus
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table workflowstatus
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("workflowstatus.id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("workflowstatus.id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("workflowstatus.id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("workflowstatus.id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("workflowstatus.id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("workflowstatus.id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("workflowstatus.id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("workflowstatus.id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("workflowstatus.id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("workflowstatus.id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("workflowstatus.id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("workflowstatus.id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andStatusCodeIsNull() {
			addCriterion("workflowstatus.statusCode is null");
			return (Criteria) this;
		}

		public Criteria andStatusCodeIsNotNull() {
			addCriterion("workflowstatus.statusCode is not null");
			return (Criteria) this;
		}

		public Criteria andStatusCodeEqualTo(String value) {
			addCriterion("workflowstatus.statusCode =", value, "statusCode");
			return (Criteria) this;
		}

		public Criteria andStatusCodeNotEqualTo(String value) {
			addCriterion("workflowstatus.statusCode <>", value, "statusCode");
			return (Criteria) this;
		}

		public Criteria andStatusCodeGreaterThan(String value) {
			addCriterion("workflowstatus.statusCode >", value, "statusCode");
			return (Criteria) this;
		}

		public Criteria andStatusCodeGreaterThanOrEqualTo(String value) {
			addCriterion("workflowstatus.statusCode >=", value, "statusCode");
			return (Criteria) this;
		}

		public Criteria andStatusCodeLessThan(String value) {
			addCriterion("workflowstatus.statusCode <", value, "statusCode");
			return (Criteria) this;
		}

		public Criteria andStatusCodeLessThanOrEqualTo(String value) {
			addCriterion("workflowstatus.statusCode <=", value, "statusCode");
			return (Criteria) this;
		}

		public Criteria andStatusCodeLike(String value) {
			addCriterion("workflowstatus.statusCode like", value, "statusCode");
			return (Criteria) this;
		}

		public Criteria andStatusCodeNotLike(String value) {
			addCriterion("workflowstatus.statusCode not like", value, "statusCode");
			return (Criteria) this;
		}

		public Criteria andStatusCodeIn(List<String> values) {
			addCriterion("workflowstatus.statusCode in", values, "statusCode");
			return (Criteria) this;
		}

		public Criteria andStatusCodeNotIn(List<String> values) {
			addCriterion("workflowstatus.statusCode not in", values, "statusCode");
			return (Criteria) this;
		}

		public Criteria andStatusCodeBetween(String value1, String value2) {
			addCriterion("workflowstatus.statusCode between", value1, value2, "statusCode");
			return (Criteria) this;
		}

		public Criteria andStatusCodeNotBetween(String value1, String value2) {
			addCriterion("workflowstatus.statusCode not between", value1, value2, "statusCode");
			return (Criteria) this;
		}

		public Criteria andStatusNameIsNull() {
			addCriterion("workflowstatus.statusName is null");
			return (Criteria) this;
		}

		public Criteria andStatusNameIsNotNull() {
			addCriterion("workflowstatus.statusName is not null");
			return (Criteria) this;
		}

		public Criteria andStatusNameEqualTo(String value) {
			addCriterion("workflowstatus.statusName =", value, "statusName");
			return (Criteria) this;
		}

		public Criteria andStatusNameNotEqualTo(String value) {
			addCriterion("workflowstatus.statusName <>", value, "statusName");
			return (Criteria) this;
		}

		public Criteria andStatusNameGreaterThan(String value) {
			addCriterion("workflowstatus.statusName >", value, "statusName");
			return (Criteria) this;
		}

		public Criteria andStatusNameGreaterThanOrEqualTo(String value) {
			addCriterion("workflowstatus.statusName >=", value, "statusName");
			return (Criteria) this;
		}

		public Criteria andStatusNameLessThan(String value) {
			addCriterion("workflowstatus.statusName <", value, "statusName");
			return (Criteria) this;
		}

		public Criteria andStatusNameLessThanOrEqualTo(String value) {
			addCriterion("workflowstatus.statusName <=", value, "statusName");
			return (Criteria) this;
		}

		public Criteria andStatusNameLike(String value) {
			addCriterion("workflowstatus.statusName like", value, "statusName");
			return (Criteria) this;
		}

		public Criteria andStatusNameNotLike(String value) {
			addCriterion("workflowstatus.statusName not like", value, "statusName");
			return (Criteria) this;
		}

		public Criteria andStatusNameIn(List<String> values) {
			addCriterion("workflowstatus.statusName in", values, "statusName");
			return (Criteria) this;
		}

		public Criteria andStatusNameNotIn(List<String> values) {
			addCriterion("workflowstatus.statusName not in", values, "statusName");
			return (Criteria) this;
		}

		public Criteria andStatusNameBetween(String value1, String value2) {
			addCriterion("workflowstatus.statusName between", value1, value2, "statusName");
			return (Criteria) this;
		}

		public Criteria andStatusNameNotBetween(String value1, String value2) {
			addCriterion("workflowstatus.statusName not between", value1, value2, "statusName");
			return (Criteria) this;
		}

		public Criteria andIsActiveIsNull() {
			addCriterion("workflowstatus.isActive is null");
			return (Criteria) this;
		}

		public Criteria andIsActiveIsNotNull() {
			addCriterion("workflowstatus.isActive is not null");
			return (Criteria) this;
		}

		public Criteria andIsActiveEqualTo(Boolean value) {
			addCriterion("workflowstatus.isActive =", value, "isActive");
			return (Criteria) this;
		}

		public Criteria andIsActiveNotEqualTo(Boolean value) {
			addCriterion("workflowstatus.isActive <>", value, "isActive");
			return (Criteria) this;
		}

		public Criteria andIsActiveGreaterThan(Boolean value) {
			addCriterion("workflowstatus.isActive >", value, "isActive");
			return (Criteria) this;
		}

		public Criteria andIsActiveGreaterThanOrEqualTo(Boolean value) {
			addCriterion("workflowstatus.isActive >=", value, "isActive");
			return (Criteria) this;
		}

		public Criteria andIsActiveLessThan(Boolean value) {
			addCriterion("workflowstatus.isActive <", value, "isActive");
			return (Criteria) this;
		}

		public Criteria andIsActiveLessThanOrEqualTo(Boolean value) {
			addCriterion("workflowstatus.isActive <=", value, "isActive");
			return (Criteria) this;
		}

		public Criteria andIsActiveIn(List<Boolean> values) {
			addCriterion("workflowstatus.isActive in", values, "isActive");
			return (Criteria) this;
		}

		public Criteria andIsActiveNotIn(List<Boolean> values) {
			addCriterion("workflowstatus.isActive not in", values, "isActive");
			return (Criteria) this;
		}

		public Criteria andIsActiveBetween(Boolean value1, Boolean value2) {
			addCriterion("workflowstatus.isActive between", value1, value2, "isActive");
			return (Criteria) this;
		}

		public Criteria andIsActiveNotBetween(Boolean value1, Boolean value2) {
			addCriterion("workflowstatus.isActive not between", value1, value2, "isActive");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNull() {
			addCriterion("workflowstatus.description is null");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNotNull() {
			addCriterion("workflowstatus.description is not null");
			return (Criteria) this;
		}

		public Criteria andDescriptionEqualTo(String value) {
			addCriterion("workflowstatus.description =", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotEqualTo(String value) {
			addCriterion("workflowstatus.description <>", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThan(String value) {
			addCriterion("workflowstatus.description >", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
			addCriterion("workflowstatus.description >=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThan(String value) {
			addCriterion("workflowstatus.description <", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThanOrEqualTo(String value) {
			addCriterion("workflowstatus.description <=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLike(String value) {
			addCriterion("workflowstatus.description like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotLike(String value) {
			addCriterion("workflowstatus.description not like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionIn(List<String> values) {
			addCriterion("workflowstatus.description in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotIn(List<String> values) {
			addCriterion("workflowstatus.description not in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionBetween(String value1, String value2) {
			addCriterion("workflowstatus.description between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotBetween(String value1, String value2) {
			addCriterion("workflowstatus.description not between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andNotesIsNull() {
			addCriterion("workflowstatus.notes is null");
			return (Criteria) this;
		}

		public Criteria andNotesIsNotNull() {
			addCriterion("workflowstatus.notes is not null");
			return (Criteria) this;
		}

		public Criteria andNotesEqualTo(String value) {
			addCriterion("workflowstatus.notes =", value, "notes");
			return (Criteria) this;
		}

		public Criteria andNotesNotEqualTo(String value) {
			addCriterion("workflowstatus.notes <>", value, "notes");
			return (Criteria) this;
		}

		public Criteria andNotesGreaterThan(String value) {
			addCriterion("workflowstatus.notes >", value, "notes");
			return (Criteria) this;
		}

		public Criteria andNotesGreaterThanOrEqualTo(String value) {
			addCriterion("workflowstatus.notes >=", value, "notes");
			return (Criteria) this;
		}

		public Criteria andNotesLessThan(String value) {
			addCriterion("workflowstatus.notes <", value, "notes");
			return (Criteria) this;
		}

		public Criteria andNotesLessThanOrEqualTo(String value) {
			addCriterion("workflowstatus.notes <=", value, "notes");
			return (Criteria) this;
		}

		public Criteria andNotesLike(String value) {
			addCriterion("workflowstatus.notes like", value, "notes");
			return (Criteria) this;
		}

		public Criteria andNotesNotLike(String value) {
			addCriterion("workflowstatus.notes not like", value, "notes");
			return (Criteria) this;
		}

		public Criteria andNotesIn(List<String> values) {
			addCriterion("workflowstatus.notes in", values, "notes");
			return (Criteria) this;
		}

		public Criteria andNotesNotIn(List<String> values) {
			addCriterion("workflowstatus.notes not in", values, "notes");
			return (Criteria) this;
		}

		public Criteria andNotesBetween(String value1, String value2) {
			addCriterion("workflowstatus.notes between", value1, value2, "notes");
			return (Criteria) this;
		}

		public Criteria andNotesNotBetween(String value1, String value2) {
			addCriterion("workflowstatus.notes not between", value1, value2, "notes");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table workflowstatus
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table workflowstatus
     *
     * @mbg.generated do_not_delete_during_merge Wed Feb 28 16:53:30 IST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}