package com.asraf.constants;

public class MessageKey {
	
	public static class Validation {
		private static final String VALIDATION = "validation";
		public static final String ERROR = VALIDATION + ".error";
	}
	
	public static class Password {
		private static final String PASSWORD = "password";
		public static final String MISMATCH = PASSWORD + ".mismatch";
	}
	
	public static class DuplicateResourceFoundException {
		public static final String DuplicateResourceFoundException = "duplicateresourcefoundexception";
		public static class Invalid {
			private static final String INVALID = DuplicateResourceFoundException + ".invalid";
			public static final String ENTRIES = INVALID + ".entries";
		}
	}
	
	public static class UserStatus {
		private static final String USERSTATUS = "userstatus";
		public static final String REQUIRED = USERSTATUS + ".required";
	}
	
}
