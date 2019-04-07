package com.asraf.constants;

public class ErrorCode {

	/*
	 * Request and Response error
	 */
	public static final class HttpMessageNotReadable {
		public static final String VALUE = "httpmessagenotreadable";
	}

	public static final class HttpMessageNotWritable {
		public static final String VALUE = "httpmessagenotwritable";
	}

	/*
	 * Service and Repository layer exception
	 */
	public static final class Exception {
		public static final String VALUE = "exception";

		public static final class Messaging {
			public static final String VALUE = Exception.VALUE + ".messaging";
		}

		public static final class Resource {
			private static final String VALUE = Exception.VALUE + ".resource";

			public static final class DuplicateFound {
				public static final String VALUE = Resource.VALUE + ".duplicatefound";

				public static final class Invalid {
					private static final String VALUE = DuplicateFound.VALUE + ".invalid";
					public static final String ENTRIES = Invalid.VALUE + ".entries";
				}
			}

			public static final class NotFound {
				public static final String VALUE = Resource.VALUE + ".notfound";

				public static final class Invalid {
					private static final String VALUE = NotFound.VALUE + ".invalid";
					public static final String ENTRIES = Invalid.VALUE + ".entries";
				}
			}
		}

		public static final class DataIntegrityViolation {
			public static final String VALUE = Exception.VALUE + ".dataintegrityviolation";
			public static final String CONSTRAINT_VIOLATION = DataIntegrityViolation.VALUE
					+ ".constraintviolation";
		}

		public static final class IllegalArgument {
			public static final String VALUE = Exception.VALUE + ".illegalargument";
		}

		public static final class AccessDenied {
			public static final String VALUE = Exception.VALUE + ".accessdenied";
		}
	}

	/*
	 * Validation error
	 */
	public static final class Validation {
		private static final String VALUE = "validation";
		public static final String ERROR = Validation.VALUE + ".error";
	}

	public static final class Password {
		private static final String VALUE = "password";
		public static final String MISMATCH = Password.VALUE + ".mismatch";
	}

	public static final class UserStatus {
		private static final String USERSTATUS = "userstatus";
		public static final String REQUIRED = USERSTATUS + ".required";
	}

}
