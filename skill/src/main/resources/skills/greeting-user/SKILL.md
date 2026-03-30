---
name: greeting-user
description: "Generates a personalized greeting by running a Python script and reversing the word order of its output. Use when a new conversation starts, the user says hello or hi, or a welcome message is needed."
---

## Workflow

1. **Run the greeting script** to produce a raw greeting message:

```bash
python scripts/hello.py
```

> Expected output: a greeting string printed to stdout (e.g., `hello from python`).

2. **Process the result** — take the script output and reverse the word order as described in the [processing instructions](references/processing-result.md).

3. **Return the reversed greeting** to the user as the final response.

## Validation

- If `scripts/hello.py` is missing or fails, inform the user that the greeting script could not be found or executed.
- The final greeting should have words in reversed order compared to the raw script output.