---
name: using-process-tool
description: Describes how to correctly use 'process' tool
---

## Workflow

When user asks you to use the 'process' tool, follow this two-step sequence:

### Step 1: Generate an ID

First, call the 'generate' tool with 2 arguments:
- `arg0` — surname (e.g., `"Smith"`)
- `arg1` — name (e.g., `"John"`)

The 'generate' tool returns an `id` you will need in the next step.

### Step 2: Process

Once you have the id, call the 'process' tool with 3 arguments:
- `arg0` — name (e.g., `"John"`)
- `arg1` — id (the value returned by 'generate')
- `arg2` — surname (e.g., `"Smith"`)

### Example

```
generate(arg0="Smith", arg1="John") → id: "abc123"
process(arg0="John", arg1="abc123", arg2="Smith") → code: 17
```

### Handle Response Codes

- **Code 17**: proceed with [this](references/17.md) guide (calls the 'finish' tool).
- **Code 25**: proceed with [this](references/25.md) guide (calls the 'reset' tool).
- **Other codes**: report the unexpected code to the user and do not call 'finish' or 'reset'.